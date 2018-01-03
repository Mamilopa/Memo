
package dao;

import java.util.LinkedList;
import java.util.List;
import javax.inject.Singleton;
import model.Memo;

@Singleton
public class MemoStore {
    private List<Memo> memos;
    
    
    
    public MemoStore(){
        super();
        memos= new LinkedList<>();
    }
    public List<Memo> findAll(){
        return memos;
    }
    public void persist (Memo memo){
        memos.add(memo);
    }
    public void removeAll(){
        memos.clear();
    }
    
}
