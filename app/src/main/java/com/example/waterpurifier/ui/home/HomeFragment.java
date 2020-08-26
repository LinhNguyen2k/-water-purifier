package com.example.waterpurifier.ui.home;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.waterpurifier.R;
import com.example.waterpurifier.databinding.FragmentHomeBinding;
import com.squareup.picasso.Picasso;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
public class HomeFragment extends Fragment {
    FragmentHomeBinding binding;
    Adapter_SPBanChay adapter_spBanChay;
    Adater_MayDienGiai adater_mayDienGiai;
    Adapter_HeThongLocNuoc adapter_heThongLocNuoc;
    Adapter_MayLocNuoc adapter_mayLocNuoc;
    Adapter_LinhKienMayLocNuoc adapter_linhKienMayLocNuoc;
    String urlAPI = "https://demo8117695.mockable.io/list_SanPhamBanChayNhat";
    String urlAPI_MayDG = "https://demo8117695.mockable.io/list_MayDienGiai";
    String urlAPI_HTLocNuoc = "https://demo8117695.mockable.io/list_HeThongLocnuoc";
    String urlAPI_MayLocNuoc = "https://demo8117695.mockable.io/list_MayLocNuoc";
    String urlAPI_LinhKien = "https://demo8117695.mockable.io/list_LinhKienMayLocNuoc";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        setlayout();
        new DoGetData().execute();
        new DoGetData_MayDG().execute();
        new DoGetData_HTLocNuoc().execute();
        new DoGetData_MayLocNuoc().execute();
        new DoGetData_LinhKienLocNuoc().execute();
        return binding.getRoot();
    }

    private void setlayout() {
        ArrayList<String> slide = new ArrayList<>();
        slide.add("http://locnuocvanminh.vn/img/Slide/jbz5kc6y7q.jpeg");
        slide.add("http://locnuocvanminh.vn/img/Slide/jdciz8dq2e.jpeg");
        slide.add("http://locnuocvanminh.vn/img/Slide/jbz5kc6y7q.jpeg");
        slide.add("http://locnuocvanminh.vn/img/Slide/jdciz8dq2e.jpeg");
        slide.add("http://locnuocvanminh.vn/img/Slide/jbz5kc6y7q.jpeg");

        for (int i = 0; i < slide.size(); i++) {
            ImageView imageView = new ImageView(getContext());
            Picasso.with(getContext()).load(slide.get(i)).into(imageView);
            //cho image tu can full
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            binding.Viewflipper.addView(imageView);
        }
        //cho tu chay trong 5s
        binding.Viewflipper.setFlipInterval(4000);
        binding.Viewflipper.setAutoStart(true);
        //goi Animation de anh chay tu tu
        @SuppressLint("ResourceType") Animation animation_slide_in = AnimationUtils.loadAnimation(getContext(), R.transition.slide_in_right);
        @SuppressLint("ResourceType") Animation animation_slide_out = AnimationUtils.loadAnimation(getContext(), R.transition.slide_out_right);
        binding.Viewflipper.setInAnimation(animation_slide_in);
        binding.Viewflipper.setOutAnimation(animation_slide_out);

    }

    private class DoGetData extends AsyncTask<Void, Void, Void> {
        String result = "";
        List<Contact_SPBanChay> contacts;


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                URL url = new URL(urlAPI);

                URLConnection connection = url.openConnection();
                InputStream inputStream = connection.getInputStream();
                int byteCharacter;
                while ((byteCharacter = inputStream.read()) != -1) {
                    result += (char) byteCharacter;
                }
                //co chuoi json => add vao list
                Log.d("TAG", "doInBackground: " + result);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            contacts = new ArrayList<>();
            try {
                JSONArray jsonArray = new JSONArray(result);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String price = jsonObject.getString("id");
                    String name = jsonObject.getString("publisher_id");
                    String image = jsonObject.getString("thumb");
                    contacts.add(new Contact_SPBanChay(price, image, name));

                }
//                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),
//                        LinearLayoutManager.VERTICAL, false);
                RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 1, RecyclerView.HORIZONTAL, false);
                adapter_spBanChay = new Adapter_SPBanChay(contacts, getContext());
                binding.RcSPBanChay.setLayoutManager(layoutManager);
                binding.RcSPBanChay.setAdapter(adapter_spBanChay);

            } catch (Exception e) {
                e.printStackTrace();
            }

            super.onPostExecute(aVoid);
        }
    }

    private class DoGetData_MayDG extends AsyncTask<Void, Void, Void> {
        String result = "";
        List<Contact_MayDienGiai> contacts;


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                URL url = new URL(urlAPI_MayDG);

                URLConnection connection = url.openConnection();
                InputStream inputStream = connection.getInputStream();
                int byteCharacter;
                while ((byteCharacter = inputStream.read()) != -1) {
                    result += (char) byteCharacter;
                }
                //co chuoi json => add vao list
                Log.d("TAG", "doInBackground: " + result);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            contacts = new ArrayList<>();
            try {
                JSONArray jsonArray = new JSONArray(result);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String price = jsonObject.getString("id");
                    String name = jsonObject.getString("publisher_id");
                    String image = jsonObject.getString("thumb");
                    contacts.add(new Contact_MayDienGiai(price, image, name));

                }
//                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),
//                        LinearLayoutManager.VERTICAL, false);
                RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 1, RecyclerView.HORIZONTAL, false);
                adater_mayDienGiai = new Adater_MayDienGiai(contacts, getContext());
                binding.RcSPDienGiai.setLayoutManager(layoutManager);
                binding.RcSPDienGiai.setAdapter(adater_mayDienGiai);
            } catch (Exception e) {
                e.printStackTrace();
            }
            super.onPostExecute(aVoid);
        }
    }

    private class DoGetData_HTLocNuoc extends AsyncTask<Void, Void, Void> {
        String result = "";
        List<Contact_HeThongLocNuoc> contacts;


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                URL url = new URL(urlAPI_HTLocNuoc);

                URLConnection connection = url.openConnection();
                InputStream inputStream = connection.getInputStream();
                int byteCharacter;
                while ((byteCharacter = inputStream.read()) != -1) {
                    result += (char) byteCharacter;
                }
                //co chuoi json => add vao list
                Log.d("TAG", "doInBackground: " + result);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            contacts = new ArrayList<>();
            try {
                JSONArray jsonArray = new JSONArray(result);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String price = jsonObject.getString("id");
                    String name = jsonObject.getString("publisher_id");
                    String image = jsonObject.getString("thumb");
                    contacts.add(new Contact_HeThongLocNuoc(price, image, name));

                }
//                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),
//                        LinearLayoutManager.VERTICAL, false);
                RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 1, RecyclerView.HORIZONTAL, false);
                adapter_heThongLocNuoc = new Adapter_HeThongLocNuoc(contacts, getContext());
                binding.RcSPLocNuoc.setLayoutManager(layoutManager);
                binding.RcSPLocNuoc.setAdapter(adapter_heThongLocNuoc);
            } catch (Exception e) {
                e.printStackTrace();
            }
            super.onPostExecute(aVoid);
        }
    }

    private class DoGetData_MayLocNuoc extends AsyncTask<Void, Void, Void> {
        String result = "";
        List<Contac_MayLocNuoc> contacts;


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                URL url = new URL(urlAPI_MayLocNuoc);

                URLConnection connection = url.openConnection();
                InputStream inputStream = connection.getInputStream();
                int byteCharacter;
                while ((byteCharacter = inputStream.read()) != -1) {
                    result += (char) byteCharacter;
                }
                //co chuoi json => add vao list
                Log.d("TAG", "doInBackground: " + result);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            contacts = new ArrayList<>();
            try {
                JSONArray jsonArray = new JSONArray(result);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String price = jsonObject.getString("id");
                    String name = jsonObject.getString("publisher_id");
                    String image = jsonObject.getString("thumb");
                    contacts.add(new Contac_MayLocNuoc(price, image, name));

                }
//                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),
//                        LinearLayoutManager.VERTICAL, false);
                RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 1, RecyclerView.HORIZONTAL, false);
                adapter_mayLocNuoc = new Adapter_MayLocNuoc(contacts, getContext());
                binding.RcMayLocNuoc.setLayoutManager(layoutManager);
                binding.RcMayLocNuoc.setAdapter(adapter_mayLocNuoc);
            } catch (Exception e) {
                e.printStackTrace();
            }
            super.onPostExecute(aVoid);
        }
    }

    private class DoGetData_LinhKienLocNuoc extends AsyncTask<Void, Void, Void> {
        String result = "";
        List<Coctac_LinhKien> contacts;


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                URL url = new URL(urlAPI_LinhKien);

                URLConnection connection = url.openConnection();
                InputStream inputStream = connection.getInputStream();
                int byteCharacter;
                while ((byteCharacter = inputStream.read()) != -1) {
                    result += (char) byteCharacter;
                }
                //co chuoi json => add vao list
                Log.d("TAG", "doInBackground: " + result);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            contacts = new ArrayList<>();
            try {
                JSONArray jsonArray = new JSONArray(result);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String price = jsonObject.getString("id");
                    String name = jsonObject.getString("publisher_id");
                    String image = jsonObject.getString("thumb");
                    contacts.add(new Coctac_LinhKien(price, image, name));

                }
//                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext(),
//                        LinearLayoutManager.VERTICAL, false);
                RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 1, RecyclerView.HORIZONTAL, false);
                adapter_linhKienMayLocNuoc = new Adapter_LinhKienMayLocNuoc(contacts, getContext());
                binding.RcLinhKien.setLayoutManager(layoutManager);
                binding.RcLinhKien.setAdapter(adapter_linhKienMayLocNuoc);
            } catch (Exception e) {
                e.printStackTrace();
            }
            super.onPostExecute(aVoid);
        }
    }
}

