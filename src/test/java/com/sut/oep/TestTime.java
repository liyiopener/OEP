package com.sut.oep;

import com.sut.oep.model.User;
import com.sut.oep.util.TimeFormat;
import org.junit.Test;

public class TestTime {
    @Test
    public void testTime(){
        User user = new User();
        user.setCreateTime(TimeFormat.getTime());
        System.out.println(user);
    }
}
