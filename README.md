## ArticleView
ArticleView can display article using RecyclerView.

## Usage

```java
        ArticleAdapter mAdapter = new ArticleAdapter(s);
        mArticleView.setAdapter(mAdapter);
        mArticleView.setLayoutManager(new FlowLayoutManager());
```
`ArticleAdapter` needs a input string or a list of string.Using string is convenient as you don't need to consider to split the string into list.

```java
String s = "Nothing succeeds like confidence.When you are truly confident,it radiates from you like sunlight,and attracts success to you like a magnet."
                +"\n"
                +"It's important to believe in yourself.Believe that you can do it under any circumstances,because if you believe you can,then you really will.The belief keeps you searching for answers,which means that pretty soon you will get them.";
```

Also you can fetch remote json data,and construct a list of string.

**Note:There is a "\n" between two paragraphs.**

## Drag
If you want item can be dragged,please add below code:

```java
        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(mAdapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(mArticleView);
```

#### Style
`ArticleView` also support custom settings like font size and font color.You can set them using xml:

```java
    <com.hackerli.library.ArticleView
        xmlns:app="http://schemas.android.com/apk/res-auto"
        android:id="@+id/article_view"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:font_color="#141414"
        app:font_size="20"/>
```