import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class EmailAdapter extends RecyclerView.Adapter<EmailAdapter.EmailViewHolder> {

    private final List<Email> emailList;

    public EmailAdapter(List<Email> emailList) {
        this.emailList = emailList;
    }

    @NonNull
    @Override
    public EmailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_email, parent, false);
        return new EmailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmailViewHolder holder, int position) {
        Email email = emailList.get(position);
        holder.emailIcon.setText(email.getInitial());
        holder.senderName.setText(email.getSenderName());
        holder.emailSubject.setText(email.getSubject());
        holder.emailTime.setText(email.getTime());
    }

    @Override
    public int getItemCount() {
        return emailList.size();
    }

    static class EmailViewHolder extends RecyclerView.ViewHolder {
        TextView emailIcon, senderName, emailSubject, emailTime;

        public EmailViewHolder(@NonNull View itemView) {
            super(itemView);
            emailIcon = itemView.findViewById(R.id.email_icon);
            senderName = itemView.findViewById(R.id.sender_name);
            emailSubject = itemView.findViewById(R.id.email_subject);
            emailTime = itemView.findViewById(R.id.email_time);
        }
    }
}