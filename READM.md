## 마이크로서비스 로컬 설정하기

# 마이크로 서비스 준비를 위한 카프카 설정 - 로컬
'''
cd batch
#1.run_zookeeper.bat
#2.run_kafka.bat
'''
- 위의 서비스는 항상 띄워 줍니다.

# 각 서비스 실행 - 예: 대리기사
'''
#5.run_drivercall.bat
#6.run_drivermanage.bat
#7.run_driverassign.bat
#8.run_customer.bat
'''

# 서비스 실행
서비스 실행은 자신의비즈이름calls 로 호출 하면 됩니다.
서비스는 gateway내의 application.yml 파일을 확인 하면 됩니다.
'''
- id: drivercall
  uri: http://localhost:8081
  predicates:
    - Path=/drivercalls/** 
- id: drivermanage
  uri: http://localhost:8082
  predicates:
    - Path=/drivermanages/** 
- id: driverassign
  uri: http://localhost:8084
  predicates:
    - Path=/driverassigns/** 
'''
즉, 서비스 포트는 8081,8082, 8084 이며, drivercenter 일 경우

호출 내용은 Drivercall.java 파일 내에 다음과 같이 설정 되어 있습니다.
'''
@Entity
@Table(name="Drivercall_table")
public class Drivercall {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String tel;
    private String location;
    private String status; //호출,호출중,호출확정,호출취소
    private Integer cost;
'''

따라서, 호출은 다음과 같이 하면 됩니다.
'''
http localhost:8081/drivercalls/ tel="01023456789" location="성산시영아파트" cost=500000 status="호출"
'''
