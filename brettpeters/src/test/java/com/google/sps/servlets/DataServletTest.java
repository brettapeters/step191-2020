package com.google.sps.servlets;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.inject.Provider;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

/**
 * Unit tests for {@link DataServlet}.
 */
@RunWith(JUnit4.class)
public class DataServletTest {

    @Rule
    public final MockitoRule mockito = MockitoJUnit.rule();

    @Mock
    private Provider<String> userNameProvider;

    @Mock
    private HttpServletRequest httpServletRequest;
    @Mock
    private HttpServletResponse httpServletResponse;
    @Mock
    private PrintWriter printWriter;

    private DataServlet dataServlet;

    @Before
    public void setUp() throws IOException {
        dataServlet = new DataServlet(userNameProvider);
        when(userNameProvider.get()).thenReturn("Test");
        when(httpServletResponse.getWriter()).thenReturn(printWriter);
    }

    @Test
    public void doGet_writesResponse() throws IOException {
        dataServlet.doGet(httpServletRequest, httpServletResponse);
        verify(printWriter).println("<h1>Hello Test!</h1>");
    }
}
