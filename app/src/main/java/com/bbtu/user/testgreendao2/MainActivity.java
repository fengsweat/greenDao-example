package com.bbtu.user.testgreendao2;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.DaoMaster;
import com.example.DaoSession;
import com.example.History;
import com.example.HistoryDao;

import java.sql.Timestamp;

public class MainActivity extends AppCompatActivity {
    private SQLiteDatabase db;
    private EditText editText;
    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private Cursor cursor;

    Button mSend;
    EditText mEt;
    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.send).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addHistory("", mEt.getText().toString());
                mEt.setText("");
            }
        });

        mEt = (EditText) findViewById(R.id.edtext);
        mListView = (ListView)findViewById(R.id.list);
        initDatabase();
    }

    void initDatabase(){

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "bbtim-db", null);
        db = helper.getWritableDatabase();

        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();

        String textColumn = HistoryDao.Properties.Message_id.columnName;
        String orderBy = textColumn + " COLLATE LOCALIZED ASC";
        cursor = db.query(daoSession.getHistoryDao().getTablename(), daoSession.getHistoryDao().getAllColumns(), null, null, null, null, orderBy);
        String[] from = {HistoryDao.Properties.Message_id.columnName, HistoryDao.Properties.Message.columnName};
        int[] to = {android.R.id.text1, android.R.id.text2};

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2, cursor, from,
                to);

        mListView.setAdapter(adapter);
    }

    private void addHistory(String msgId, String msg){
        String time = new Timestamp(System.currentTimeMillis()).toString();
        History history = new History(null, time, msg);
        daoSession.getHistoryDao().insertOrReplace(history);

        cursor.requery();
    }




}
