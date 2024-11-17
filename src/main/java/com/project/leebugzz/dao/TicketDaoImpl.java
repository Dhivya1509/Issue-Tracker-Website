package com.project.leebugzz.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.leebugzz.model.MessageEntity;
import com.project.leebugzz.model.TicketEntity;
import com.project.leebugzz.row.mapper.MessageRowMapper;
import com.project.leebugzz.row.mapper.TicketRowMapper;

@Repository
@Transactional
public class TicketDaoImpl implements TicketDao {

	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<TicketEntity> getTickets(){
		String name=jdbcTemplate.queryForObject("select user.firstName from user,loggeduser where user.email=loggeduser.email order by loggeduser.id desc limit 1",String.class);
		List<TicketEntity> tickets=jdbcTemplate.query("select * from ticket where createrName=?",new Object[] {name}, new TicketRowMapper());
		return tickets;
	}
	@Override
	public Object addTicket(TicketEntity ticketEntity) {
		// TODO Auto-generated method stub
		String name=jdbcTemplate.queryForObject("select user.firstName from user,loggeduser where user.email=loggeduser.email order by loggeduser.id desc limit 1",String.class);
		jdbcTemplate.update("insert into ticket(title,createrName,createDate) values(?,?,?)",
				new Object[] { ticketEntity.getTitle(),name,java.time.LocalDate.now()});

		return null;
	}
	@Override
	public TicketEntity getTicket(int ticketId) {
		// TODO Auto-generated method stub
		TicketEntity ticket=jdbcTemplate.queryForObject("select * from ticket where ticketId=?",new Object[] {ticketId}, new TicketRowMapper());
		return ticket;
	}

	@Override
	public int update(TicketEntity p){    
	    String sql="update ticket set status='"+p.getStatus()+"' where ticketId="+p.getTicketId()+"";    
	    return jdbcTemplate.update(sql);    
	}   
	@Override
	public TicketEntity getTicketById(int ticketId){    
	    String sql="select * from ticket where ticketId=?";    
	    return jdbcTemplate.queryForObject(sql, new Object[]{ticketId},new BeanPropertyRowMapper<TicketEntity>(TicketEntity.class));    
	} 
	@Override
	public void addMessage(MessageEntity messageEntity) {
		// TODO Auto-generated method stub
		jdbcTemplate.update("insert into message(ticketId,authorName,recepientName,text,createDate) values(?,(select firstName from loggedUser order by id desc limit 1),(select holderName from ticket where ticket.ticketId=?),?,?)",new Object[] {messageEntity.getTicketId(),messageEntity.getRecepientName(),messageEntity.getText(),java.time.LocalDate.now()});
		}
	@Override
	public List<MessageEntity> getMessages(int ticketId) {
        // TODO Auto-generated method stub
        List<MessageEntity> messages=jdbcTemplate.query("select * from message where ticketId=?",new Object[] {ticketId},new MessageRowMapper());
        return messages;
    }
	@Override
	public List<TicketEntity> notif() {
		String name = jdbcTemplate.queryForObject("select firstName from loggeduser order by id desc limit 1",
				String.class);
		
		List<TicketEntity> tickets = jdbcTemplate.query("select * from ticket where creatername=? and status='Completed'",
				new Object[] { name }, new TicketRowMapper());
		return tickets;
	}
}
