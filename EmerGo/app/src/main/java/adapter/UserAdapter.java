package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import unlv.erc.emergo.R;
import unlv.erc.emergo.model.User;

public class UserAdapter extends BaseAdapter{
    private List<User> userList;
    private Context context;
    public UserAdapter(Context context, List<User> users){
        this.context = context;
        this.userList = users;
    }

    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public Object getItem(int position) {
        return userList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if(view == null){
            LayoutInflater layoutInflater;
            layoutInflater = LayoutInflater.from(context);
            view = layoutInflater.inflate(R.layout.user_registered,null);
        }

        User user = userList.get(position);

        if(user!=null){
            TextView fullName = (TextView) view.findViewById(R.id.fullNameEditText);
            TextView birthday = (TextView) view.findViewById(R.id.birthdayEditText);
            TextView typeBlood = (TextView) view.findViewById(R.id.typeBloodSpinner);
            TextView cardiac = (TextView) view.findViewById(R.id.cardiacSpinner);
            TextView diabetic = (TextView) view.findViewById(R.id.diabeticSpinner);
            TextView hipertension = (TextView) view.findViewById(R.id.hipertensionSpinner);
            TextView seropositive = (TextView) view.findViewById(R.id.soropositiveSpinner);

            fullName.setText(user.getName());
            birthday.setText(user.getBirthday());
            typeBlood.setText(user.getTypeBlood());
            cardiac.setText(user.getCardiac());
            diabetic.setText(user.getDiabetic());
            hipertension.setText(user.getHypertension());
            seropositive.setText(user.getSeropositive());
        }
        return view;
    }
}
