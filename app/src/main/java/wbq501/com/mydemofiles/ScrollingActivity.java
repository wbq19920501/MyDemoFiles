package wbq501.com.mydemofiles;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;

import wbq501.com.mydemofiles.activity.Android_5x_1;
import wbq501.com.mydemofiles.view.DividerItemDecoration;

public class ScrollingActivity extends AppCompatActivity {

    private RecyclerView recyclerview;

    private String msg[] = {"android5.x控件一","android5.x控件二","android5.x控件三"
                ,"android6.x控件一","android6.x控件二","android6.x控件三"};

    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        init();

    }

    /**
     * 初始化 id等
     */
    private void init() {
        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL_LIST));
        recyclerview.setAdapter(new HomeAdapter());
    }
    class HomeAdapter extends RecyclerView.Adapter<MyViewHolder>{

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(ScrollingActivity.this).inflate(R.layout.list_item, parent, false);
            MyViewHolder holder = new MyViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, final int position) {
            holder.item_button.setText(msg[position]);
            holder.item_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch (position){
                        case 0:
                            intent = new Intent(ScrollingActivity.this, Android_5x_1.class);
                            startActivity(intent);
                            break;

                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return msg.length;
        }
    }


    class MyViewHolder extends RecyclerView.ViewHolder{
        Button item_button;

        public MyViewHolder(View itemView) {
            super(itemView);
            item_button = (Button) itemView.findViewById(R.id.list_button);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
