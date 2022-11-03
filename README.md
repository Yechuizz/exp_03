# exp_02_Layout
## 1.Android ListView的用法
（1）在activit_main.xml中使用LinearLayout布局

（2）要实现目标布局，我使用LIstView控件，为控件添加android:listSelector="#600"属性来使列表项被点击后背景色改变，并新建一个logic.xml文件来规定列表项布局，关键代码如下

![images](https://github.com/Yechuizz/exp_03/blob/main/pictures/code1.png)

（3）在MainActivity中先用一个String[] names所有保存动物名称，用一个int[] images保存所有动物图片，并定义一个List<Map<String,Object>> list1用来将内容和图片绑定在一起，关键代码如下

![images](https://github.com/Yechuizz/exp_03/blob/main/pictures/code2.png)

（4）通过listview = findViewById(R.id.list_view)找到列表控件，先新建一个SimpleAdapter类型的对象，再为listview设置适配器simpleAdapter，并为listview添加列表项点击事件，在列表项被点击时利用Toast显示选中的列表项信息，关键代码如下

![images](https://github.com/Yechuizz/exp_03/blob/main/pictures/code3.png)

（5）最终效果图如下

![images](https://github.com/Yechuizz/exp_03/blob/main/pictures/exp1.png)

## 2.创建自定义布局的AlertDialog
（1）首先创建一个简单的自定义布局，将布局文件命名为alert_dialog.xml，在activity_alert_dialog_demo.xml文件中使用一个Button控件用来弹出alert_dialog界面，设置android:onClick="alertDialogClick"，关键代码如下

![images](https://github.com/Yechuizz/exp_03/blob/main/pictures/code4.png)

![images](https://github.com/Yechuizz/exp_03/blob/main/pictures/code5.png)

（2）在AlertDialogDemo中实现alertDialogClick方法，用getLayoutInflater.inflate()来载入alert_dialog并实例化，再调用AlertDialog.Builder对象上的 setView()显示出相应布局，关键代码如下

![images](https://github.com/Yechuizz/exp_03/blob/main/pictures/code6.png)

（3）最终效果图如下

![images](https://github.com/Yechuizz/exp_03/blob/main/pictures/exp2.png)

## 3.使用XML定义菜单
（1）在activity_xml_menu.xml中设置一个TextView控件来显示用于测试的内容，在menu文件夹下新建menu_main.xml文件来保存菜单布局，关键代码如下

![images](https://github.com/Yechuizz/exp_03/blob/main/pictures/code7.png)

（2）在XmlMenu中利用textView=findViewById(R.id.txt)找到文本框并注册上下文菜单registerForContextMenu(textView)，在onCreateOptionsMenu方法中装填R.menu.menu_name菜单并添加到menu

（3）在onOptionsItemSelected方法中判断点击了哪个菜单项，并作出反应，关键代码如下

![images](https://github.com/Yechuizz/exp_03/blob/main/pictures/code8.png)

（4）最终效果图如下

![images](https://github.com/Yechuizz/exp_03/blob/main/pictures/exp3-1.png)

![images](https://github.com/Yechuizz/exp_03/blob/main/pictures/exp3-2.png)
