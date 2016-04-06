package com.example.ziyu16901.com.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ziyu16901.com.R;

import java.util.HashMap;
import java.util.List;

public class CommentReplyAdapter extends BaseAdapter {
	private LayoutInflater inflater;
	private List<HashMap<String, Object>> list; 
	private ViewHolder viewHolder;

	public CommentReplyAdapter(Context context,
			List<HashMap<String, Object>> list) {
		inflater = LayoutInflater.from(context);
		// this.list = new ArrayList<HashMap<String, Object>>();
		// this.list.addAll(list);
		this.list = list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	public void clearList() {
		this.list.clear();
	}

	public void updateList(List<HashMap<String, Object>> list_comment) {
		this.list.addAll(list_comment);
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.disscuss_comment_reply, null);
			viewHolder = new ViewHolder();
			viewHolder.tv_comment_reply_text = (TextView) convertView
					.findViewById(R.id.tv_comment_reply_text);
			viewHolder.tv_comment_reply_writer = (TextView) convertView
					.findViewById(R.id.tv_comment_reply_writer);
			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
			
		}
		viewHolder.tv_comment_reply_text.setText(list.get(position)
				.get("content").toString());
		// viewHolder.tv_comment_reply_writer.setText(list.get(position)
		// .get("user").toString());

		return convertView;
	}

	public class ViewHolder {
		private TextView tv_comment_reply_writer; 
		private TextView tv_comment_reply_text; 
	}
}
