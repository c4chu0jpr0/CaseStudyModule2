package Interface;

import CategoryMain.*;

public class IService implements Service {
    private static IService instance = new IService();
    public static IService getInstance(){return instance;}
    @Override
    public void add() {
        CheckAdd checkAdd = CheckAdd.getInstance();
        checkAdd.check();
    }

    @Override
    public void modify() {
        CheckModify checkModify = CheckModify.getInstance();
        checkModify.CheckModify();
    }

    @Override
    public void delete() {
        CheckDelete checkDelete = CheckDelete.getInstance();
        checkDelete.checkDelete();
    }

    @Override
    public void showList() {
        CheckShow checkShow = CheckShow.getInstance();
        checkShow.readFile();
    }

    @Override
    public void find() {
        CheckFind checkFind = CheckFind.getInstance();
        checkFind.CheckFind();
    }

    @Override
    public void showListH() {
        CheckHS checkHS = CheckHS.getInstan();
        checkHS.checkHS();
    }
}
