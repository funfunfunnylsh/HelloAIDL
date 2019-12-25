package com.example.helloaidl

import android.os.Parcel
import android.os.Parcelable

class Book : Parcelable {
    var bookId: Int
    var bookName: String?

    constructor(bookId: Int, bookName: String?) {
        this.bookId = bookId
        this.bookName = bookName
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(bookId)
        dest.writeString(bookName)
    }

    constructor(source: Parcel) {
        bookId = source.readInt()
        bookName = source.readString()
    }

    override fun toString(): String {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                '}'
    }


    companion object CREATOR : Parcelable.Creator<Book> {
        override fun createFromParcel(parcel: Parcel): Book {
            return Book(parcel)
        }

        override fun newArray(size: Int): Array<Book?> {
            return arrayOfNulls(size)
        }
    }
}