package com.android.deptlibrary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> implements Filterable {


    private Context mCtx;
    private List<Book> bookList;
    private List<Book> bookListFull;


    public BookAdapter(Context mCtx, List<Book> bookList) {
        this.mCtx = mCtx;
        this.bookList = bookList;
        bookListFull = new ArrayList<>(bookList);//search


    }

    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.book_list, null);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BookViewHolder holder, int position) {
        Book book = bookList.get(position);
        holder.book_no.setText(String.valueOf(book.getBook_no()));
        holder.book_title.setText(book.getBook_title());
        holder.domain.setText(book.getDomain_name());
        holder.author.setText(book.getAuthor());
        holder.publication.setText(book.getPublication());
        holder.availability.setText(book.getAvailability());
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    //search
    public Filter getFilter(){
        return exampleFilter;
    }
    private Filter exampleFilter=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Book> filteredList = new ArrayList<>();
            if(constraint==null || constraint.length()==0)
            {
                filteredList.addAll(bookListFull);
            }
            else{
                String filterPattern=constraint.toString().toLowerCase().trim();
                for(Book item:bookListFull){
                    if(item.getBook_title().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                    else if(item.getAuthor().toLowerCase().contains(filterPattern)){
                        filteredList.add(item);
                    }
                    else if(item.getPublication().toLowerCase().contains(filterPattern)){
                        filteredList.add(item);
                    }
                    else if(item.getDomain_name().toLowerCase().contains(filterPattern)){
                        filteredList.add(item);
                    }
                    else if(item.getBook_no().toLowerCase().contains(filterPattern)){
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results=new FilterResults();
            results.values=filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            bookList.clear();
            bookList.addAll((List) results.values);
            notifyDataSetChanged();

        }
    };

    class BookViewHolder extends RecyclerView.ViewHolder {

        TextView book_no, book_title, domain, author, publication, availability;

        public BookViewHolder(View itemView) {
            super(itemView);


            domain = itemView.findViewById(R.id.domain);
            book_no = itemView.findViewById(R.id.book_no);
            book_title = itemView.findViewById(R.id.book_title);
            author = itemView.findViewById(R.id.author);
            publication = itemView.findViewById(R.id.publication);
            availability = itemView.findViewById(R.id.availability);
        }
    }




}
