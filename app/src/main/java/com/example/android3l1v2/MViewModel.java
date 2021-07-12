package com.example.android3l1v2;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class MViewModel extends ViewModel {
public MutableLiveData<List<BookModel>> list = new MutableLiveData<>();

public void addAll(){
    List<BookModel>bookLis = new ArrayList<>();
    bookLis.add(new BookModel("Чисто английское убийство", R.drawable.angliyskoeubiystvo));
    bookLis.add(new BookModel("Весь мир в кармане", R.drawable.mirvkarmane));
    bookLis.add(new BookModel("Переправа", R.drawable.pereprava));
    bookLis.add(new BookModel("Голос ночной птицы", R.drawable.golosptici));
    bookLis.add(new BookModel("Талантливый мистер Рипли", R.drawable.misterripli));
    list.setValue(bookLis);
}


}
