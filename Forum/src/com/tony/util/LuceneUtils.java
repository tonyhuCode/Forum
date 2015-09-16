package com.tony.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import jeasy.analysis.MMAnalyzer;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriter.MaxFieldLength;
import org.apache.lucene.queryParser.MultiFieldQueryParser;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.highlight.Formatter;
import org.apache.lucene.search.highlight.Fragmenter;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.Scorer;
import org.apache.lucene.search.highlight.SimpleFragmenter;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;

public class LuceneUtils {

	private static String indexPath = "./index";
	private static Analyzer analyzer = new MMAnalyzer();

	public static String getIndexPath() {
		return indexPath;
	}

	public static void setIndexPath(String indexPath) {
		LuceneUtils.indexPath = indexPath;
	}

	public static Analyzer getAnalyzer() {
		return analyzer;
	}

	/**
	 * 获取IndexWriter
	 * 
	 * @return
	 */
	public static IndexWriter getIndexWriter() {
		try {
			return new IndexWriter(indexPath, analyzer, MaxFieldLength.LIMITED);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 关闭IndexWriter
	 * 
	 * @param indexWriter
	 */
	public static void closeIndexWriter(IndexWriter indexWriter) {
		try {
			indexWriter.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 获取IndexSearcher
	 * 
	 * @return
	 */
	public static IndexSearcher getIndexSearcher() {
		try {
			return new IndexSearcher(indexPath);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 关闭IndexSearcher
	 * 
	 * @param indexSearcher
	 */
	public static void closeIndexSearcher(IndexSearcher indexSearcher) {
		try {
			indexSearcher.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// ===

	private static Map<String, QueryParser> queryParserMap = new HashMap<String, QueryParser>();

	/**
	 * 获取QueryParser
	 * 
	 * @param fields
	 * @return
	 */
	public static QueryParser getMultiFieldQueryParser(String[] fields) {
		QueryParser queryParser = queryParserMap.get(Arrays.toString(fields));
		if (queryParser == null) {
			queryParser = new MultiFieldQueryParser(fields, analyzer);
			queryParserMap.put(Arrays.toString(fields), queryParser);
		}
		return queryParser;
	}

	// ===

	private static int fragmentSize = 200;

	/**
	 * 获取Highlighter
	 * 
	 * @param query
	 * @return
	 */
	public static Highlighter getHighlighter(Query query) {
		Formatter formatter = new SimpleHTMLFormatter("<span class='keyword'>",
				"</span>");
		Scorer scorer = new QueryScorer(query);
		Highlighter highlighter = new Highlighter(formatter, scorer);

		Fragmenter fragmenter = new SimpleFragmenter(150);
		highlighter.setTextFragmenter(fragmenter);

		return highlighter;
	}

	public static void highlight(Document doc, String fieldName,
			Highlighter highlighter) {
		try {
			String ht = highlighter.getBestFragment(analyzer, fieldName,
					doc.get(fieldName));
			if (ht == null) {
				int end = Math.min(doc.get(fieldName).length(), fragmentSize);
				ht = doc.get(fieldName).substring(0, end);
			}
			doc.getField(fieldName).setValue(ht);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
}
