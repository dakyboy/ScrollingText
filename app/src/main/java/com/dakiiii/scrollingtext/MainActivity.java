package com.dakiiii.scrollingtext;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView article_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        article_text = findViewById(R.id.article);
        registerForContextMenu(article_text);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater contextMenuInflater = getMenuInflater();
        contextMenuInflater.inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            default:
            case R.id.context_edit:
                displayToast("Edit choice clicked");
                return true;
            case R.id.context_delete:
                displayToast("Delete choice clicked");
                return true;
            case R.id.context_share:
                displayToast("Share chocie clicked`");
                return super.onContextItemSelected(item);
        }
    }

    private void displayToast(String m) {
        Toast.makeText(MainActivity.this, m, Toast.LENGTH_SHORT).show();
    }
}
