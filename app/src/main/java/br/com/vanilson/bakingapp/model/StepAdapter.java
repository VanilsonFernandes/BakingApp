package br.com.vanilson.bakingapp.model;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.com.vanilson.bakingapp.R;

public class StepAdapter extends RecyclerView.Adapter<StepAdapter.StepsAdapterViewHolder> {

    List<StepModel> steps;
    Context mContext;

    @NonNull
    @Override
    public StepAdapter.StepsAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        mContext = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.step_item, parent, false);
        return new StepsAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StepAdapter.StepsAdapterViewHolder holder, int position) {
        holder.mStepTextView.setText(steps.get(position).getShortDescription());
    }

    @Override
    public int getItemCount() {
        if (null == steps) return 0;
        return steps.size();
    }

    public void setSteps(List<StepModel> steps) {
        this.steps = steps;
        notifyDataSetChanged();
    }

    public List<StepModel> getSteps() {
        return steps;
    }

    public class StepsAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView mStepTextView;

        public StepsAdapterViewHolder(View view) {
            super(view);
            mStepTextView = view.findViewById(R.id.step_item_tv);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
//            Intent intent = new Intent(mContext, DetailActivity.class);
//            intent.putExtra(DetailActivity.RECIPES_DETAIL_KEY, recipes.get(getAdapterPosition()));
//            mContext.startActivity(intent);
            Toast.makeText(mContext,
                    "Step: "+ steps.get(getAdapterPosition()).getShortDescription() + " clicked",
                    Toast.LENGTH_LONG).show();
        }
    }
}
