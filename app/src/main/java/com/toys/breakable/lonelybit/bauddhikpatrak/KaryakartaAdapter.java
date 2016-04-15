package com.toys.breakable.lonelybit.bauddhikpatrak;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by prafulljoshi on 02/04/16.
 */
public class KaryakartaAdapter extends ArrayAdapter<Karyakarta> {


    Context context;
    List<Karyakarta> karyakartas;
    public KaryakartaAdapter(Context context, int resource, List<Karyakarta> karyakartas) {
        super(context, resource, karyakartas);
        this.context = context;
        this.karyakartas = karyakartas;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Karyakarta currentKaryakarta = karyakartas.get(position);
        View rowView = inflater.inflate(R.layout.karyakarini_row_layout, parent, false);
        TextView email = (TextView) rowView.findViewById(R.id.karyakarta_email_view_id);
        email.setText(currentKaryakarta.getEmail());
        TextView name = (TextView) rowView.findViewById(R.id.karyakarta_name_view_id);
        name.setText(currentKaryakarta.getName());
        TextView number = (TextView) rowView.findViewById(R.id.karyakarta_mobile_no_view_id);
        number.setText(currentKaryakarta.getMobileNumber());
        TextView dayitva = (TextView) rowView.findViewById(R.id.dayitva_star_name_view_id);
        dayitva.setText(currentKaryakarta.getDayitva());
        return rowView;
    }
}
