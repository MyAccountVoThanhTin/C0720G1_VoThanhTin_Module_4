package service.dictionaryIpl;

import org.springframework.stereotype.Service;
import service.IDictionary;

import java.util.HashMap;
import java.util.Map;

@Service
public class DictionaryServiceIpl implements IDictionary {
    @Override
    public Map<String,String> findDictionary(){
        Map<String,String> listDictonary = new HashMap<>();
        listDictonary.put("Hello","Xin Chao");
        listDictonary.put("Name","Ten");
        listDictonary.put("Age","Tuoi");
        listDictonary.put("Address","Dia Chi");
        listDictonary.put("Love","Yeu");
        return listDictonary;
    }
}
