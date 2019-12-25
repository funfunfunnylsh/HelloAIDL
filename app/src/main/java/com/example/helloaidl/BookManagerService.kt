package com.example.helloaidl

import android.app.Service
import android.content.Intent
import android.os.IBinder
import java.util.concurrent.CopyOnWriteArrayList

class BookManagerService : Service() {
    private val TAG = BookManagerService::class.java.simpleName

    //使用CopyOnWriteArrayList来支持并发读写
    private val mBookList = CopyOnWriteArrayList<Book>()

    override fun onBind(intent: Intent): IBinder? {
        return mBinder
    }


    private val mBinder = object : IBookManager.Stub() {
        override fun addBook(book: Book) {
            mBookList.add(book)
        }

        override fun getBookList(): List<Book> {
            return mBookList
        }

    }

}