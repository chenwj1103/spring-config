- bean的生命周期:

    1.第一个层面是bean的作用范围;
    
    2.第二个层面是实例化bean所经历的一系列阶段;
    
- beanFactory和applicationContext的区别是:
  
  1.后者在setBeanFactory之后增加setApplicationContext操作
  
  2.后者的后处理器是自动注册到应用上下文中的,而前者需要手动处理.
  