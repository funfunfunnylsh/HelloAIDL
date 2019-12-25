// IBookManager.aidl
package com.example.helloaidl;
import com.example.helloaidl.Book;

interface IBookManager {
    // 获取图书列表
    List<Book> getBookList();

    //添加图书
    void addBook(in Book book);
}
