package cart.model.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.Data;
@Data
public class OrderDTO {

	private Integer orderId;
	private Integer userId;
	private Date orderDate;
	private List<OrderItemDTO>items=new ArrayList<>();

}
