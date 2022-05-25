package com.dronworks;
 
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CouponServletTest {
 
    @Mock private HttpServletRequest request;
    @Mock private HttpServletResponse response;
    @Mock private RequestDispatcher requestDispatcher;

 
    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void doGet() throws Exception {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(printWriter);
        new CouponServlet().doGet(request, response);
        assertEquals("SUPERSALE", stringWriter.toString());
    }

    @Test
    public void doPost() throws Exception {
        String couponName = "SUPERSALE";
        when(request.getParameter("coupon")).thenReturn(couponName);
        when(request.getRequestDispatcher("response.jsp")).thenReturn(requestDispatcher);
        new CouponServlet().doPost(request, response);
        verify(request).setAttribute("discount", "Discount for coupon " + couponName + " is 50%!");
        verify(requestDispatcher).forward(request, response);
    }

}