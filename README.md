# collectibles-show

  这是一个展示拍卖物品的小网站, 可以展示当期的所有拍卖物品, 并且能查看单个物品详情. 后台可以添加, 修改每件物品.

## 安装

  gradle
    
    brew install gradle

## 修改配置
 
  application.yml
    
    url:
    username:
    password:
    
## 运行

  启动
     
    gradle run
    
  验证
   
    curl http://localhost:8080/index.html
