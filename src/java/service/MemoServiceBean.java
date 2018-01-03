
package service;

import dao.MemoStore;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import model.Memo;

@Stateless
public class MemoServiceBean {

    @Inject
    private MemoStore memoStore;

    public List<Memo> getAllMemos(){
        return memoStore.findAll();
    }
    public void addMemo(Memo memo){
        Memo newMemo = new Memo();
        newMemo.setDescription(memo.getDescription());
        newMemo.setCreated(new Date());
        memoStore.persist(newMemo);
    }
    public void resetMemos(){
        memoStore.removeAll();
    }
}
