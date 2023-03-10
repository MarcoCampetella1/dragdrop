package com.example.prova;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipDescription;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.ViewGroup;
import android.view.DragEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener, View.OnDragListener {
    private TextView t;
    private Button b;
    private ImageView i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Settaggio dei nostri elementi
        t = (TextView) findViewById(R.id.txt1);
        i = (ImageView) findViewById(R.id.imm);
        b = (Button) findViewById(R.id.btnDrag);
        //implementa eventi
        implementaEventi();
    }
    private void implementaEventi()
    {
        //Implemento i tre oggetti che possono essere spostati con il cursore se premuti
        t.setOnLongClickListener(this);
        i.setOnLongClickListener(this);
        b.setOnLongClickListener(this);
        //Setto i 3 layout in modo che possano contenere gli oggetti spostati
        findViewById(R.id.layout1).setOnDragListener(this);
        findViewById(R.id.layout2).setOnDragListener(this);
        findViewById(R.id.layout3).setOnDragListener(this);
    }

    @Override
    public boolean onLongClick(View v) {
        return false;
    }

    @Override
    public boolean onDrag(View v, DragEvent event) {
        int action = event.getAction();
        switch(action){
            case DragEvent.ACTION_DRAG_STARTED:
              if(event.getClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {
                  return true;
              }else {
                  return false;
              }
        }
        return false;
    }
}