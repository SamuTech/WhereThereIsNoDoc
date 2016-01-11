package com.marvik.apps.wherethereisnodoc.database.transactionsmanager.crudoperations;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/**
 * Created by victor on 1/10/2016.
 */
public interface DatabaseCRUDOperations {

    Context getContext();

    Uri getUri();

    Uri insert(ContentValues values);

    Cursor query(String[] projection, String selection, String[] selectionArgs, String sortOrder);

    int update(ContentValues values, String selection, String[] selectionArgs);

    int delete(String selection, String[] selectionArgs);


}
