package com.blacktea.ztine.learnmyblog.Parser;

import com.blacktea.ztine.learnmyblog.model.Author;
import com.blacktea.ztine.learnmyblog.model.Blog;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ztine on 16/6/4.
 */
public class BlogListXmlParser {


        /**
         * 用于解析博客列表的xml，返回Blog的List集合对象
         *
         * @param inputStream
         * @param encode
         * @return
         * @throws XmlPullParserException
         * @throws IOException
         */
        public static List<Blog> getListBlogs(InputStream inputStream, String encode) throws XmlPullParserException, IOException {

            List<Blog> mBlogs = null;
            Blog mBlog = null;
            Author author = null;

            //获取XmlPullParser实例
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = factory.newPullParser();
            parser.setInput(inputStream, encode);
            //获取解析事件
            int eventType = parser.getEventType();
            //当xml文档未到尾端时
            while (eventType != XmlPullParser.END_DOCUMENT) {
                switch (eventType) {
                    //解析根标签的时候，实例化集合
                    case XmlPullParser.START_DOCUMENT:
                        mBlogs = new ArrayList<Blog>();
                        mBlog = new Blog();
                        author = new Author();

                        break;
                    case XmlPullParser.START_TAG:
                        //当解析到entry标签的时候，实例化Blog对象
                        if ("entry".equals(parser.getName())) {
                            mBlog = new Blog();
                        }
                        if ("id".equals(parser.getName())) {
                            parser.next();
                            mBlog.setbID(parser.getText());
                        } else if ("title".equals(parser.getName())) {
                            parser.next();
                            //特殊处理
                            if (!"博客园".equals(parser.getText())) {
                                mBlog.setbTitle(parser.getText());
                            }
                        } else if ("summary".equals(parser.getName())) {
                            parser.next();
                            mBlog.setbSummary(parser.getText());
                        } else if ("published".equals(parser.getName())) {
                            parser.next();
                            mBlog.setbPublished(parser.getText());
                        } else if ("name".equals(parser.getName())) {
                            parser.next();
                            author.setaName(parser.getText());
                        } else if ("uri".equals(parser.getName())) {
                            parser.next();
                            author.setaUri(parser.getText());
                        } else if ("avatar".equals(parser.getName())) {
                            parser.next();
                            author.setaAvatar(parser.getText());
                        } else if ("link".equals(parser.getName())) {
                            //特殊处理
                            if (parser.getAttributeName(0).equals("rel")) {
                                mBlog.setbLink(parser.getAttributeValue(1));
                            }
                        } else if ("diggs".equals(parser.getName())) {
                            parser.next();
                            mBlog.setbDiggs(parser.getText());
                        } else if ("views".equals(parser.getName())) {
                            parser.next();
                            mBlog.setbViews(parser.getText());
                        } else if ("comments".equals(parser.getName())) {
                            parser.next();
                            mBlog.setbComments(parser.getText());
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        //当解析到entry标签结束的时候添加入Blogs集合，清空Blog对象
                        if ("entry".equals(parser.getName())) {
                            mBlog.setAuthor(author);

                            mBlogs.add(mBlog);
                            mBlog = null;
                            author = null;
                        }
                        break;

                }
                //手动跳转第一次遍历
                eventType = parser.next();
            }


            return mBlogs;

        }


}
