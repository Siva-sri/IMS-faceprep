package ims;

import java.util.ArrayList;
import java.util.List;

public class Agent {
    private String agentId;
    private String name;
    private List<Customer> customers;

    public Agent(String agentId, String name) {
        this.agentId = agentId;
        this.name = name;
        this.customers = new ArrayList<>();
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void addCustomer(Customer customer) {
        this.customers.add(customer);
    }

    @Override
    public String toString() {
        return "Agent{" +
                "agentId='" + agentId + '\'' +
                ", name='" + name + '\'' +
                ", customers=" + customers +
                '}';
    }
}
