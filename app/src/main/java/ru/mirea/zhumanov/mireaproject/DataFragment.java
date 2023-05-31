package ru.mirea.zhumanov.mireaproject;

import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ru.mirea.zhumanov.mireaproject.databinding.FragmentDataBinding;

public class DataFragment extends Fragment {

    private FragmentDataBinding binding;

    @SuppressLint("SetTextI18n")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DataViewModel dataViewModel =
                new ViewModelProvider(this).get(DataViewModel.class);

        binding = FragmentDataBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textData;
        final TextView textView2 = binding.textData2;
        textView.setText("Java — строго типизированный объектно-ориентированный язык программирования общего назначения," +
                " разработанный компанией Sun Microsystems (в последующем приобретённой компанией Oracle)." +
                " Разработка ведётся сообществом, организованным через Java Community Process; язык и основные" +
                " реализующие его технологии распространяются по лицензии GPL. Права на торговую марку принадлежат" +
                " корпорации Oracle.");

        textView2.setText("Java Development Kit (сокращенно JDK) — бесплатно распространяемый компанией Oracle Corporation" +
                " (ранее Sun Microsystems) комплект разработчика приложений на языке Java, включающий в себя компилятор Java (javac)," +
                " стандартные библиотеки классов Java, примеры, документацию, различные утилиты и исполнительную систему Java (JRE)." +
                " В состав JDK не входит интегрированная среда разработки на Java, поэтому разработчик, использующий только JDK," +
                " вынужден использовать внешний текстовый редактор и компилировать свои программы, используя утилиты командной строки.");
        //     dataViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);



        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}