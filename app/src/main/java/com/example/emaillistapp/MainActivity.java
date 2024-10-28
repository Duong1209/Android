import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private EmailAdapter emailAdapter;
    private List<Email> emailList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        emailList = new ArrayList<>();
        emailList.add(new Email("Edurila.com", "Learn Web Design", "12:34 PM"));
        emailList.add(new Email("Chris Abad", "Help make Campaign Monitor better", "11:22 AM"));
        emailList.add(new Email("Tuto.com", "Free tutorials", "11:04 AM"));
        // Add more emails as needed

        emailAdapter = new EmailAdapter(emailList);
        recyclerView.setAdapter(emailAdapter);
    }
}