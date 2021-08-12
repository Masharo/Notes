package com.example.notes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater inflater;
    private List<Note> notes;

    public NotesAdapter(Context context, List<Note> notes) {
        this.inflater = LayoutInflater.from(context);
        this.notes = notes;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.note_item, parent, false);
        return new NotesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Note note = notes.get(position);

        assert holder instanceof NotesViewHolder;
        NotesViewHolder holderNotes = (NotesViewHolder) holder;
        Context context = inflater.getContext();

        holderNotes.textViewTitle.setText(note.getTitle());
        holderNotes.textViewDescription.setText(note.getDescription());
        holderNotes.textViewDayOfWeek.setText(context.getString(note.getDayOfWeek()));
        holderNotes.textViewTitle.setBackgroundColor(note.getPriority(context));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    class NotesViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewTitle,
                         textViewDescription,
                         textViewDayOfWeek;

        public NotesViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textview_noteitem_title);
            textViewDescription = itemView.findViewById(R.id.textview_noteitem_description);
            textViewDayOfWeek = itemView.findViewById(R.id.textview_noteitem_dayofweek);
        }
    }
}
