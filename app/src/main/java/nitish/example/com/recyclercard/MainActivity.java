package nitish.example.com.recyclercard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ExampleItem>exampleList;

    private Button buttonAdd,buttonDelete;
    private EditText editTextAdd,editTextDelete;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //find buttons
        buttonAdd = findViewById(R.id.buttonadd);
        buttonDelete = findViewById(R.id.buttondelete);

        //find editText
        editTextAdd = findViewById(R.id.edittextadd);
        editTextDelete = findViewById(R.id.edittextdelete);


        generateFakeData();

        recyclerviewconfig();
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: make sure user is not allowed to submit empty form
                int position = Integer.parseInt(editTextAdd.getText().toString());
                addcard(position);
            }
        });
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = Integer.parseInt(editTextAdd.getText().toString());
                deletecard(position);
            }
        });
    }
    public void generateFakeData(){
        exampleList = new ArrayList<>();

        exampleList.add(new ExampleItem(R.drawable.oner,"clicked at studio"));
        exampleList.add(new ExampleItem(R.drawable.twor,"clicked at studio"));
        exampleList.add(new ExampleItem(R.drawable.threer,"clicked at studio"));
        exampleList.add(new ExampleItem(R.drawable.fourr,"clicked at studio"));
    }
    public void recyclerviewconfig(){
        //config for Rv
        recyclerView = findViewById(R.id.recyclerview);
        //performance
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        adapter = new ExampleAdapter(exampleList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
    public void addcard(int position){
        exampleList.add(position, new ExampleItem(R.drawable.threer,"new card added"));
//        adapter.notifyDataSetChanged();
        adapter.notifyItemInserted(position);
    }
    public void deletecard(int position){
        exampleList.remove(position);
        adapter.notifyItemRemoved(position);
    }
}
