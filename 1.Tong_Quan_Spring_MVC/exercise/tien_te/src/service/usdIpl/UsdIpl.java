package service.usdIpl;

import common.UsdException;
import org.springframework.stereotype.Service;
import service.IUsd;
@Service
public class UsdIpl implements IUsd {

    @Override
    public double tinhUsd(String menhGia, double num) throws UsdException {
        if(menhGia.equals("vnd")){
            return num*23000;
        }else {
            if(num == 0){
              throw new UsdException("Không Thể Chuyển Từ USD Sang VND Khi Mệnh Giá Bằng 0 !");
            }else {
                return num/23000;
            }
        }
    }
}
