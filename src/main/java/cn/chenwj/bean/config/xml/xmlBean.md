## xml类型的bean的流程:

1. bean配置信息首先定义了bean的实现及以来关系,
2. Spring根据各种形式的bean配置信息在容器内部建立bean定义注册表;
3. 然后根据注册表加载实例化bean,并建立bean与bean之间的依赖关系,
4. 最后将准备就绪的bean放进bean的缓冲池中供应用程序调用.

## IOC容器装配一个bean 

 ```
 <bean id="car" class="cn.chenwj.Car">
 ```
## 依赖注入 


如果一个类中没有构造函数,则默认的会隐式的提供一个无参构造函数;

如果显示的提供一个有参数构造,则也需要提供一个无参的构造函数

1.属性注入

````
<bean id="car" class="cn.chenwj.bean.Car">

<property name ="maxSpeed"><value>200</value></property>
<property name ="brand"><value>红旗</value></property>
<property name ="price"><value>200000</value></property>

</bean

````

要求该bean的实现类中必须有对应的属性的set方法.

2.构造函数注入

- 按类型匹配入参



````

public Car(String brand,double price){
    this.brand=brand;
    this.price=price;
    }
        
<bean id ="car1" class="cn.chenwj.bean.Car">

<constructor-arg type="java.lang.String">
<value>红旗 </value>
</constructor-arg>

<constructor-arg type="double">
<value>200.0</value>
</constructor-arg>

</bean>

````

- 按索引匹配入参

````

public Car(String brand,double price,String corp){
    this.brand=brand;
    this.price=price;
    this.corp=corp;
    }
        
<bean id ="car1" class="cn.chenwj.bean.Car">

<constructor-arg index="0" value="红旗"/>
<constructor-arg index="1" value="2000"/>
<constructor-arg index="2" value="中国一汽"/>

</bean>

````


- 联合使用类型和索引匹配入参

为了区分两个构造函数


````

public Car(String brand,int price,String corp){
    this.brand=brand;
    this.price=price;
    this.corp=corp;
    }
    
    
public Car(String brand,double price,String corp){
    this.brand=brand;
    this.price=price;
    this.corp=corp;
    }
        
        
<bean id ="car1" class="cn.chenwj.bean.Car">

<constructor-arg index="0" type="com.lang.String">
<value>红旗</value>
</constructor-arg>


<constructor-arg index="1" type="int">
<value>20000</value>
</constructor-arg>


<constructor-arg index="2" type="com.lang.String">
<value>中国一汽</value>
</constructor-arg>

</bean>

````



- 通过自身类型反射匹配入参

````

public Boss(String name,Car car,Office office){
    this.name=name;
    this.car=car;
    this.office=office;
    }

<bean id ="boss" class="cn.chenwj.bean.Boss">

<constructor-arg >
<value>John</value>
</constructor-arg>

<constructor-arg>
<ref bean="car">
</constructor-arg>

<constructor-arg>
<ref bean="office">
</constructor-arg>

</bean>


<bean id ="car" class="cn.chenwj.bean.Car">

<bean id ="office" class="cn.chenwj.bean.Office">

````

- 循环引用问题

只需将bean的注入,由构造函数的注入改为属性注入的方式就可以了.


3.工厂方法注入


````
public class CarFactory {
   public Car createHongQiCar(){
	   Car car = new Car();
	   car.setBrand("红旗CA72");
	   return car;
   }
   
   public static Car createCar(){
	   Car car = new Car();
	   return car;
   }
}

````

- 非静态工厂方法


````
<bean id="carFactory" class="com.smart.ditype.CarFactory" />

<bean id ="car5" factory-bean="carFactory" factoy-method="crateHongQiCar"/>


````
 
- 静态工厂方法

````

<bean id ="car" class="com.smart.ditype.CarFactory" factory-method="createCar"/>

```` 

## 注入参数详解

- 集合类型的属性

````
<bean id="boss1" class="com.smart.attr.Boss">
		<property name="car" ref="car" />
		<property name="favorites">
			< list>
				<value>看报</value>
				<value>赛车</value>
				<value>高尔夫</value>
				</list>
			<set>
				<value>看报</value>
				<value>赛车</value>
				<value>高尔夫</value>
			</set>
		</property>
		<property name="jobs">
			<map>
				<entry >
					<key>
						<value>AM</value>
					</key>
					<value>会见客户</value>
				</entry>
				<entry>
					<key>
						<value>PM</value>
					</key>
					<value>公司内部会议</value>
				</entry>
			</map>
		</property>
		<property name="mails">
			<props>
				<prop key="jobMail">john-office@smart.com</prop>
				<prop key="lifeMail">john-life@smart.com</prop>
			</props>
		</property>
		<property name="jobTime">
			<map>
				<entry>
					<key>
						<value>会见客户</value>
					</key>
					<value>124</value>
				</entry>
			</map>
		</property>
	</bean>



````
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 