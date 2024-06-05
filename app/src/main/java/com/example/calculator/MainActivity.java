package com.example.calculator;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import kotlin.collections.DoubleIterator;

public class MainActivity extends AppCompatActivity implements OnClickItem{

    TextView name;
    TextView trangtinh;
    RecyclerView recyclerViewbanTinh;
    TextView result;
    ArrayList<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _init();

        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.add("6");
        list.add("7");
        list.add("8");
        list.add("9");
        list.add("+");
        list.add("-");
        list.add("*");
        list.add("/");
        list.add("%");


        tinhToanAdapter adapter = new tinhToanAdapter(this,list);
        recyclerViewbanTinh.setHasFixedSize(true);
        recyclerViewbanTinh.setLayoutManager(new GridLayoutManager(this,3));
        recyclerViewbanTinh.setAdapter(adapter);

        //Bấm kết quả để hiển thị kết quả
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _tinh(trangtinh.getText().toString());
            }
        });

        //Giữ kết quả để xóa
        result.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                trangtinh.setText("");
                return true;
            }
        });

    }

    private void _tinh(String s){
        Double result = null;
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
        try {
            result = (double) engine.eval(s);
        }catch (ScriptException e){
            Toast.makeText(this, "Invalid Value!", Toast.LENGTH_SHORT).show();
        }
        if(result!=null){
            this.result.setText(String.valueOf(result.doubleValue()));
        }
    }

    private void _init(){
        name = findViewById(R.id.name);
        trangtinh = findViewById(R.id.trangtinh);
        result = findViewById(R.id.result);
        recyclerViewbanTinh = findViewById(R.id.recycleView);
    }

    @Override
    public void onClicked(int s) {
        trangtinh.setText(trangtinh.getText()+list.get(s));
    }
}