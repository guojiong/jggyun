package com.demo.test.testcases.res.channel; 

import org.testng.annotations.Test; 
import com.demo.test.base.BaseParpare; 
import com.demo.test.utils.SuperAction; 

public class ChannelPage_001_ChannelAdd_Test extends BaseParpare{ 
    @Test 
    public void channelAdd() { 
        SuperAction.parseExcel("jgg/res/testcases/channel.xlsx","001_ChannelAdd",seleniumUtil);
    }
}