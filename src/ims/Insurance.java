package ims;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Insurance {
    private List<Agent> agents;
    private List<Customer> customers;
    private List<Policy> policies;

    public Insurance() {
        this.agents = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.policies = new ArrayList<>();
    }

    public void addAgent(Agent agent) {
        agents.add(agent);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void addPolicy(Policy policy) {
        policies.add(policy);
    }

    public Agent findAgentById(String agentId) {
        for (Agent agent : agents) {
            if (agent.getAgentId().equals(agentId)) {
                return agent;
            }
        }
        return null;
    }

    public Customer findCustomerById(String customerId) {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(customerId)) {
                return customer;
            }
        }
        return null;
    }

    public Policy findPolicyByNumber(String policyNumber) {
        for (Policy policy : policies) {
            if (policy.getPolicyNumber().equals(policyNumber)) {
                return policy;
            }
        }
        return null;
    }

    public void linkCustomerToAgent(String agentId, String customerId) {
        Agent agent = findAgentById(agentId);
        Customer customer = findCustomerById(customerId);
        if (agent != null && customer != null) {
            agent.addCustomer(customer);
            System.out.println("Customer linked to agent successfully.");
        } else {
            System.out.println("Agent or Customer not found.");
        }
    }

    public void bookPolicyThroughAgent(String agentId, String customerId, String policyNumber) {
        Agent agent = findAgentById(agentId);
        Customer customer = findCustomerById(customerId);
        Policy policy = findPolicyByNumber(policyNumber);
        if (agent != null && customer != null && policy != null) {
            customer.addPolicy(policy);
            if (!agent.getCustomers().contains(customer)) {
                agent.addCustomer(customer);
            }
            System.out.println("Policy booked through agent successfully.");
        } else {
            System.out.println("Agent, Customer, or Policy not found.");
        }
    }

    public static void main(String[] args) {
        Insurance ims = new Insurance();
        Scanner scanner = new Scanner(System.in);

        // Sample data
        Agent agent = new Agent("A001", "John Doe");
        Customer customer = new Customer("C001", "Jane Smith", "1234567890");
        Policy policy = new Policy("P001", "Health", 5000, "2024-01-01", "2025-01-01");

        ims.addAgent(agent);
        ims.addCustomer(customer);
        ims.addPolicy(policy);

        // Main menu
        while (true) {
            System.out.println("1. Add Agent");
            System.out.println("2. Add Customer");
            System.out.println("3. Add Policy");
            System.out.println("4. View Agents");
            System.out.println("5. View Customers");
            System.out.println("6. View Policies");
            System.out.println("7. Link Customer to Agent");
            System.out.println("8. Book Policy through Agent");
            System.out.println("9. Calculate Policy Premium");
            System.out.println("10. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter agent ID: ");
                    String agentId = scanner.nextLine();
                    System.out.print("Enter agent name: ");
                    String agentName = scanner.nextLine();
                    ims.addAgent(new Agent(agentId, agentName));
                    break;
                case 2:
                    System.out.print("Enter customer ID: ");
                    String customerId = scanner.nextLine();
                    System.out.print("Enter customer name: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Enter customer contact number: ");
                    String contactNumber = scanner.nextLine();
                    ims.addCustomer(new Customer(customerId, customerName, contactNumber));
                    break;
                case 3:
                    System.out.print("Enter policy number: ");
                    String policyNumber = scanner.nextLine();
                    System.out.print("Enter policy type: ");
                    String policyType = scanner.nextLine();
                    System.out.print("Enter base premium: ");
                    double basePremium = scanner.nextDouble();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter start date (yyyy-mm-dd): ");
                    String startDate = scanner.nextLine();
                    System.out.print("Enter end date (yyyy-mm-dd): ");
                    String endDate = scanner.nextLine();
                    ims.addPolicy(new Policy(policyNumber, policyType, basePremium, startDate, endDate));
                    break;
                case 4:
                    System.out.println("Agents:");
                    for (Agent a : ims.agents) {
                        System.out.println(a);
                    }
                    break;
                case 5:
                    System.out.println("Customers:");
                    for (Customer c : ims.customers) {
                        System.out.println(c);
                    }
                    break;
                case 6:
                    System.out.println("Policies:");
                    for (Policy p : ims.policies) {
                        System.out.println(p);
                    }
                    break;
                case 7:
                    System.out.print("Enter agent ID to link customer: ");
                    String linkAgentId = scanner.nextLine();
                    System.out.print("Enter customer ID to be linked: ");
                    String linkCustomerId = scanner.nextLine();
                    ims.linkCustomerToAgent(linkAgentId, linkCustomerId);
                    break;
                case 8:
                    System.out.print("Enter agent ID to book policy through: ");
                    String bookAgentId = scanner.nextLine();
                    System.out.print("Enter customer ID to book policy for: ");
                    String bookCustomerId = scanner.nextLine();
                    System.out.print("Enter policy number to book: ");
                    String bookPolicyNumber = scanner.nextLine();
                    ims.bookPolicyThroughAgent(bookAgentId, bookCustomerId, bookPolicyNumber);
                    break;
                case 9:
                    System.out.print("Enter policy number to calculate premium: ");
                    String calcPolicyNumber = scanner.nextLine();
                    Policy calcPolicy = ims.findPolicyByNumber(calcPolicyNumber);
                    if (calcPolicy != null) {
                        double premium = calcPolicy.calculatePremium();
                        System.out.println("Calculated Premium for policy " + calcPolicyNumber + ": " + premium);
                    } else {
                        System.out.println("Policy not found.");
                    }
                    break;
                case 10:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
