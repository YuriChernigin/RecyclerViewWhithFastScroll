package com.example.recyclerview.recycler;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.recyclerview.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by www_c on 21.04.2016.
 */
public class MyRecyclerAdapter extends RecyclerView.Adapter <MyRecyclerAdapter.ViewHolder> {
    private static final int SIZE = 40;
    private final List<String> itemsName;
    private final String alphbetChar;
    private Context context;


    public static MyRecyclerAdapter newInstance(Context context){
        List<String> itemsName = new ArrayList<>();
        String alphabetChar = context.getString(R.string.item_char_string);
        String format = context.getString(R.string.item_name_string);
        Context context_send = context;
        for (int i = 0; i < SIZE; i++){
            itemsName.add(format + " " + String.valueOf(i+1));
        }
        return new MyRecyclerAdapter(itemsName, alphabetChar, context_send);
    }

    private MyRecyclerAdapter(List<String> items, String alphbetChar, Context context){
        this.itemsName = items;
        this.alphbetChar = alphbetChar;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_list_item, parent, false);
        return ViewHolder.newInstance(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int positionName) {
        String textName = itemsName.get(positionName);
        String textChar = alphbetChar;
        boolean notChar = false;

        if (positionName == 0 || positionName == 5 || positionName == 10 || positionName == 15 || positionName == 20 || positionName == 25)
            notChar = false;
        else
            notChar = true;

        holder.setText(textChar, textName, notChar, context);
    }

    @Override
    public int getItemCount() {
        return itemsName.size();
    }


    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView nameItemText;
        private final TextView charItemText;
        private int exp_position;

        public static ViewHolder newInstance(View itemView) {
            List<TextView> textView = new ArrayList<>();
            TextView nameItemText = (TextView) itemView.findViewById(R.id.itemName);
            textView.add(nameItemText);
            TextView charItemText = (TextView) itemView.findViewById(R.id.itemChar);
            textView.add(charItemText);


            return new ViewHolder(itemView, textView);
        }

        private ViewHolder(View itemView, List<TextView> textView){
            super(itemView);
            this.nameItemText = textView.get(0);
            this.charItemText = textView.get(1);
        }

        public void setText(CharSequence charAlphbet, CharSequence textName, boolean notChar, Context context){
            charItemText.setText(charAlphbet);
            nameItemText.setText(textName);
            if (notChar){

                charItemText.setTextColor(context.getResources().getColor(R.color.white));
            }
            else
                charItemText.setTextColor(context.getResources().getColor(R.color.colorAccent));
        }

    }
}
