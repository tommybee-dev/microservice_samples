## ����ũ�μ��� ���� �����ϱ�

# ����ũ�� ���� �غ� ���� ī��ī ���� - ����
'''
cd batch
#1.run_zookeeper.bat
#2.run_kafka.bat
'''
- ���� ���񽺴� �׻� ��� �ݴϴ�.

# �� ���� ���� - ��: �븮���
'''
#5.run_drivercall.bat
#6.run_drivermanage.bat
#7.run_driverassign.bat
#8.run_customer.bat
'''

# ���� ����
���� ������ �ڽ��Ǻ����̸�calls �� ȣ�� �ϸ� �˴ϴ�.
���񽺴� gateway���� application.yml ������ Ȯ�� �ϸ� �˴ϴ�.
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
��, ���� ��Ʈ�� 8081,8082, 8084 �̸�, drivercenter �� ���

ȣ�� ������ Drivercall.java ���� ���� ������ ���� ���� �Ǿ� �ֽ��ϴ�.
'''
@Entity
@Table(name="Drivercall_table")
public class Drivercall {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String tel;
    private String location;
    private String status; //ȣ��,ȣ����,ȣ��Ȯ��,ȣ�����
    private Integer cost;
'''

����, ȣ���� ������ ���� �ϸ� �˴ϴ�.
'''
http localhost:8081/drivercalls/ tel="01023456789" location="����ÿ�����Ʈ" cost=500000 status="ȣ��"
'''
