package com.tony.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.document.Document;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.Highlighter;
import org.springframework.stereotype.Repository;

import com.tony.bean.CommonTopicReply;
import com.tony.dao.LuceneIndexDao;
import com.tony.util.DocumentUtils;
import com.tony.util.LuceneUtils;

@Repository("luceneIndexDao")
public class LuceneIndexDaoImpl implements LuceneIndexDao{

	@Override
	public void createIndex(CommonTopicReply common) {
		Document doc = DocumentUtils.common2Document(common);
		IndexWriter indexWriter = LuceneUtils.getIndexWriter();
		try {
			indexWriter.addDocument(doc);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			LuceneUtils.closeIndexWriter(indexWriter);
		}
	}

	@Override
	public List<CommonTopicReply> search(String queryString) {
		IndexSearcher indexSearcher = LuceneUtils.getIndexSearcher();
		try {
			QueryParser queryParser = LuceneUtils.getMultiFieldQueryParser(new String[] { "title", "content" });
			Query query = queryParser.parse(queryString);
			
			TopDocs topDocs  = indexSearcher.search(query, null, 100);
			Highlighter highlighter = LuceneUtils.getHighlighter(query);
			
			List<CommonTopicReply> resultList = new ArrayList<CommonTopicReply>();
			for(int i = 0; i < topDocs.totalHits; i++){
				ScoreDoc scoreDoc = topDocs.scoreDocs[i];
				int docSn = scoreDoc.doc;
				Document doc = indexSearcher.doc(docSn);
				
				// ¸ßÁÁ
				LuceneUtils.highlight(doc, "title", highlighter);
				LuceneUtils.highlight(doc, "content", highlighter);
				
				CommonTopicReply common = DocumentUtils.document2common(doc);
				resultList.add(common);
			}
			return resultList;
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			LuceneUtils.closeIndexSearcher(indexSearcher);
		}
	}

}
