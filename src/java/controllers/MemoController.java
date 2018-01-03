package controllers;

import java.awt.event.ActionEvent;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import model.Memo;
import service.MemoServiceBean;


@SessionScoped
@Named
public class MemoController implements Serializable {
    
    private Memo memo;
    
    
    @Inject
    private MemoServiceBean memoService;
    
    public MemoController(){
        memo=new Memo();
            }
    public Memo getMemo(){
        return memo;
    }
    public void setMemo(Memo memo){
        this.memo = memo;
    }
    
    public void doAdd(ActionEvent event){
        memoService.addMemo(memo);
        memo.setDescription("");
    }
    public void doReset(ActionEvent event){
        memoService.resetMemos();
    }
    public List<Memo> getMemos(){
        return memoService.getAllMemos();
    }
    
}
