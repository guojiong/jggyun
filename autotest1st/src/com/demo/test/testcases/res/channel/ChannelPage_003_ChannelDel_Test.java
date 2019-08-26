package com.demo.test.testcases.res.channel; 

import org.testng.annotations.Test; 
import com.demo.test.base.BaseParpare; 
import com.demo.test.utils.SuperAction; 

public class ChannelPage_003_ChannelDel_Test extends BaseParpare{ 
    @Test 
    public void channelDel() { 
        SuperAction.parseExcel("jgg/res/testcases/channel.xlsx","003_ChannelDel",seleniumUtil);
    }
}