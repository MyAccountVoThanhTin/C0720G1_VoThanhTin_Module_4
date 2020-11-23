package service.serviceipl;

import org.springframework.stereotype.Service;
import service.SumService;

@Service
public class Sum2Number implements SumService {

    @Override
    public int sum2Number(int a, int b) {
        return a+b;
    }
}
