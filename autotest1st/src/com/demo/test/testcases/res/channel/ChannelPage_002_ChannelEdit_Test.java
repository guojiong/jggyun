package com.demo.test.testcases.res.channel; 

import org.testng.annotations.Test; 
import com.demo.test.base.BaseParpare; 
import com.demo.test.utils.SuperAction; 

public class ChannelPage_002_ChannelEdit_Test extends BaseParpare{ 
    @Test 
    public void channelEdit() { 
        SuperAction.parseExcel("jgg/res/testcases/channel.xlsx","002_ChannelEdit",seleniumUtil);
    }
}