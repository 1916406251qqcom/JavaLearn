
<h1>CSS3</h1>
<hr />
<h3>文本新特性</h3>
<pre><code>CSS3中1个较为常用的文本特性: 

    1.  文本阴影

        格式: 

        text-shadow: x长度 y长度 [模糊距离] 阴影颜色;
</code></pre>

<h3>边框阴影  ***</h3>
<pre><code>在CSS3中 我们可以不借助设计软件, 而通过代码 快速的创建一个圆角的元素 , 也可以不借助设计软件, 快速的创建一个拥有阴影的元素 !

-   边框圆角
    border-radius:圆角长度;

    长度50% , 表示圆形(只有宽和高相同时, 是正圆形 , 其它为椭圆形) ;

-   边框阴影
    box-shadow: x偏移 y偏移 [模糊距离] [阴影大小] 阴影颜色;
</code></pre>

<h3>阴影案例 -- 图片选项卡 ***</h3>
<pre><code>HTML部分: 

&lt;div&gt;
    &lt;div class=&quot;div1&quot;&gt;
        &lt;img src=&quot;images/img_1.jpg&quot;&gt;
        &lt;p&gt;这是一个风景图片&lt;/p&gt;
    &lt;/div&gt;
&lt;/div&gt;


CSS部分: 

.div1:hover{
    box-shadow: 0px 0px 0px 0px #999;

}
.div1{
    display: inline-block;
    width:200px;
    height:180px;
    margin: 40px;
    border:1px solid #999;
    box-shadow:6px 6px 6px #999;
}

.div1 img{
    width:200px;
}

.div1 p{
    text-align: center;
}
</code></pre>

<h3>阴影案例 -- 文字选项卡  ***</h3>
<pre><code>HTML部分: 

    &lt;div&gt;
        &lt;div class=&quot;div1&quot;&gt;
            &lt;div&gt;1&lt;/div&gt;
            &lt;p&gt;这是一个风景图片&lt;/p&gt;
        &lt;/div&gt;
    &lt;/div&gt;


CSS部分: 

    .div1 {
        display: inline-block;
        width: 180px;
        height: 220px;
        margin: 40px;
        border:1px solid #999;
        box-shadow:5px 5px 3px #999;
    }

    .div1 div {
        display: inline-block; 
        width : 180px;
        height: 150px;
        line-height: 150px;
        text-align: center;
        font-size: 66px;
        font-weight: bold;
        color: #fff;
        background-color: #239923;
    }

    .div1 p{
        margin: 0px;
        padding: 0px;
        line-height: 70px;
        text-align: center;
    }
</code></pre>

<h3>CSS3背景颜色渐变效果</h3>
<pre><code>背景颜色渐变, 让一个元素, 在多个指定的颜色之间平稳的渐变, 过渡!
</code></pre>

<h3></h3>
<pre><code>-   线性渐变

    格式: 

            background:linear-gradient([方向/角度],颜色1,颜色2...颜色n);

        方向的取值: 

            -   向下是默认效果,方向可以忽略
            -   向右: to right
            -   向左: to left
            -   向右下: to bottom right


        上述的方向取值, 都不重要 , 无需关注, 我们一般通过角度来指定方向, 
        写法:数字deg;


    案例: 
        上到下渐变案例
        #div1{
            background: linear-gradient(#00f,#f00);
        }
        左到右渐变案例
        #div2{
            background: linear-gradient(to right,#00f,#f00);
        }
        左上到右下渐变案例
        #div3{
            background: linear-gradient(to bottom right,#00f,#f00);
        }
        使用角度控制渐变案例
        #div4{
            background: linear-gradient(150deg,#00f,#f00,#0f0,#ff0,#0ff,#f0f);
        }
</code></pre>

<h3></h3>
<pre><code>-   径向渐变    (圆形渐变)

    格式: 

        background:radial-gradient(颜色1,颜色2...颜色n);


    案例: 
        div{
            width:200px;
            height:200px;
            background:radial-gradient(#f00,#0f0,#00f,#ff0,#0ff,#f0f);
        }
</code></pre>

<h3>过渡效果	***</h3>
<pre><code>CSS3中 可以设定, 一个元素在变更样式时, 添加过渡时长!

格式: 

    transition:动作 秒数s;

一般我们采用 transition:all 秒数s;

案例: 

    HTML部分:

        &lt;div&gt;&lt;/div&gt;

    CSS部分:

        div{
            width:200px;
            height:200px;
            background-color:#00f;
            transition:width 2s;
        }

        div:hover{
            width:1000px;
        }
</code></pre>

<h3></h3>
<pre><code>常见CSS3按钮示例 

body{
    background-color: #239923;
}
button{
    padding-bottom: 15px;
    padding-top: 15px;
    padding-left: 25px;
    padding-right: 25px;
    border:2px solid #fff;
    background-color:  #239923;
    color:#fff;
    border-radius: 5px;
    transition:all 1s;
}

button:hover{
    background-color:  #fff;
    color:#239923;
    cursor: pointer;
}



html部分: 

&lt;button&gt;&lt;/button&gt;
</code></pre>

<h3>动画</h3>
<pre><code>指的是一个元素, 在多个不同的样式之间变化 !

注意:  如果使用动画 更改绝对定位或固定定位元素的位置, 使用的方向在动画持续过程中 不能改变,  例如: 

    在百分之0时, 使用left+top确定位置, 那么在后面, 必须只能使用left和top , bottom和right不能用!


格式: 

    步骤1. 定义一个动画
        @keyframes 动画名称{
            0%{
                样式
            }
            10%{
                样式
            }
            ...
            100%{
                样式
            }
        }

        百分比的值, 可以定义n个, 但是必须要指定0%和100%;


    步骤2. 将一个动画绑定到一个元素上
        格式: 

            选择器{
                animation: 动画名称 持续时间s;
                animation-iteration-count:重复次数;
            }


逐帧动画案例: 

    CSS部分: 

        @keyframes myani{
            0%{
                background-image:url(&quot;images/bomb01.png&quot;);
            }
            5%{
                background-image:url(&quot;images/bomb02.png&quot;);
            }
            10%{
                background-image:url(&quot;images/bomb03.png&quot;);
            }
            15%{
                background-image:url(&quot;images/bomb04.png&quot;);
            }
            20%{
                background-image:url(&quot;images/bomb05.png&quot;);
            }
            25%{
                background-image:url(&quot;images/bomb06.png&quot;);
            }
            30%{
                background-image:url(&quot;images/bomb07.png&quot;);
            }
            35%{
                background-image:url(&quot;images/bomb08.png&quot;);
            }
            40%{
                background-image:url(&quot;images/bomb09.png&quot;);
            }
            45%{
                background-image:url(&quot;images/bomb10.png&quot;);
            }
            50%{
                background-image:url(&quot;images/bomb11.png&quot;);
            }
            55%{
                background-image:url(&quot;images/bomb12.png&quot;);
            }
            60%{
                background-image:url(&quot;images/bomb13.png&quot;);
            }
            65%{
                background-image:url(&quot;images/bomb14.png&quot;);
            }
            70%{
                background-image:url(&quot;images/bomb15.png&quot;);
            }
            75%{
                background-image:url(&quot;images/bomb16.png&quot;);
            }
            80%{
                background-image:url(&quot;images/bomb17.png&quot;);
            }
            85%{
                background-image:url(&quot;images/bomb18.png&quot;);
            }
            90%{
                background-image:url(&quot;images/bomb19.png&quot;);
            }
            95%{
                background-image:url(&quot;images/bomb20.png&quot;);
            }
            100%{
                background-image:url(&quot;images/bomb21.png&quot;);
            }
        }

        div{
            width:500px;
            height:500px;
            background-repeat: no-repeat;
            background-size: 100% 100%;
            margin: 0 auto;

            animation:myani 3s;
            animation-iteration-count:99999;
        }


HTML部分: 

        &lt;div&gt;

        &lt;/div&gt;
</code></pre>

<h3></h3>
<pre><code>广告移动案例


@keyframes myani{
    0%{
        position:fixed;
        top:0px;
        left:0px;
    }

    25%{
        position:fixed;
        top:0px;
        left:950px;
    }

    50%{
        position:fixed;
        top:385px;
        left:950px;
    }

    75%{
        position:fixed;
        top:385px;
        left:0px;
    }

    100%{
        position:fixed;
        top:0px;
        left:0px;
    }
}


#div1{
    animation:myani 5s;
    animation-iteration-count:999999999;
    position: fixed;
    bottom:0px;
    right: 0px;
}
</code></pre>

</body>
</html>

