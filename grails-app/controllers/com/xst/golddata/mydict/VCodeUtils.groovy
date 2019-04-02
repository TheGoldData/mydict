/*
 * Copyright 2016-2019 新商态（北京）科技有限公司
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.xst.golddata.mydict

import java.awt.*
import java.awt.image.BufferedImage


class VCodeUtils {


   private static class  VCode{

        private int width = 88;
        private int height = 30;
        private int codeCount = 4;
        private int x = 18;
        private int fontHeight=24;
        private int codeY=22;
        char[] codeSequence = [ 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
                                'J',
                                'K', 'L', 'M', 'N',
                                'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
                                'X', 'Y', 'Z', '0',
                                '2', '3', '4', '5', '6', '7', '8', '9',
                                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
                                'j', 'k',
                                'm',
                                'n',
                                'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' ];

       def genVCode(){

           BufferedImage buffImg = new BufferedImage(width, height,
                   BufferedImage.TYPE_INT_RGB);
           Graphics2D g = buffImg.createGraphics();
           Random random = new Random();
           g.setColor(Color.WHITE);
           g.fillRect(0, 0, width, height);
           Font font = new Font("宋体", Font.BOLD, fontHeight);
           g.setFont(font);
           g.setColor(Color.GRAY);
           g.drawRect(0, 0, width - 1, height - 1);
           g.setColor(Color.LIGHT_GRAY);
           for (int i = 0; i < 50; i++) {
               int x = random.nextInt(width);
               int y = random.nextInt(height);
               int xl = random.nextInt(3);
               int yl = random.nextInt(3);
               g.drawOval(x, y, x + xl, y + yl);
           }

           StringBuffer randomCode = new StringBuffer();
           int red = 0, green = 0, blue = 0;
           for (int i = 0; i < codeCount; i++) {
              Graphics2D g2= g.create()
               String strRand = String.valueOf(codeSequence[random.nextInt(codeSequence.length)]);
               red = random.nextInt(127);
               green = random.nextInt(127);
               blue = random.nextInt(127);
               g2.setColor(new Color(red, green, blue));
               g2.drawString(strRand, (i ) * x+5, codeY);
               Font ff=g2.getFont()
               Font cc=ff.deriveFont(  (float)((ff.getSize()+random.nextInt(5))*1.0f));
               g2.setFont(cc)
               g2.dispose()
               randomCode.append(strRand);
           }
           return [img:buffImg,code:randomCode.toString().toLowerCase()]
       }
    }


    static def genVCode(){
        return new VCode().genVCode();
    }
}
