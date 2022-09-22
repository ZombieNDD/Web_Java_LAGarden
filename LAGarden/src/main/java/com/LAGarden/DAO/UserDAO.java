package com.LAGarden.DAO;
import java.sql.Connection;
public class UserDAO
{
    MyConnection db = null;
    public UserDAO()
    {
        db = new MyDBContext();
    }

    public int Insert(TAIKHOAN entity)
    {
        db.TAIKHOANs.Add(entity);
        db.SaveChanges();
        return entity.IDKH;
    }
    public IEnumerable<TAIKHOAN> getListPage(int page, int pageSize)
    {
        var list = db.TAIKHOANs.OrderBy(x => x.IDKH).ToPagedList(page, pageSize);
        return list;
    }
    public TAIKHOAN ViewDetail(int id)
    {
        return db.TAIKHOANs.Find(id);
    }

    public bool LoginAdmin (string userName, string passWord)
    {
        var result = db.TAIKHOANs.Count(x => x.UserName == userName && x.Password == passWord && x.Roles == 1);
        if (result >0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public bool Login(string userName, string passWord)
    {
        var result = db.TAIKHOANs.Count(x => x.UserName == userName && x.Password == passWord && x.Roles != 1);
        if (result > 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public bool CheckUserName(string userName)
    {
        return db.TAIKHOANs.Count(x => x.UserName == userName) > 0;
    }
    public bool CheckEmail(string email)
    {
        return db.TAIKHOANs.Count(x => x.Email == email) > 0;
    }

    public TAIKHOAN GetByID(string userName)
    {
        return db.TAIKHOANs.FirstOrDefault(x => x.UserName == userName);
    }
    public int Update(TAIKHOAN tk)
    {
        db.SaveChanges();
        return 1;
    }
}