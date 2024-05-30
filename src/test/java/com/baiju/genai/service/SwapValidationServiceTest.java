package com.baiju.genai.service;

import static org.junit.jupiter.api.Assertions.*;

import com.baiju.genai.domain.ActionType;
import com.baiju.genai.domain.SwapState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SwapValidationServiceTest {

    private SwapValidationService service;

    @BeforeEach
    public void setUp() {
        service = new SwapValidationService();
    }

    @Test
    public void testOpenState() {
        assertTrue(service.isActionPermitted(SwapState.OPEN, ActionType.MODI));
        assertTrue(service.isActionPermitted(SwapState.OPEN, ActionType.CORR));
        assertTrue(service.isActionPermitted(SwapState.OPEN, ActionType.VALU));
        assertTrue(service.isActionPermitted(SwapState.OPEN, ActionType.MARU));
        assertTrue(service.isActionPermitted(SwapState.OPEN, ActionType.PRTO));
        assertTrue(service.isActionPermitted(SwapState.OPEN, ActionType.EROR));
        assertTrue(service.isActionPermitted(SwapState.OPEN, ActionType.TERM));
    }

    @Test
    public void testTerminatedState() {
        assertTrue(service.isActionPermitted(SwapState.TERMINATED, ActionType.MODI));
        assertTrue(service.isActionPermitted(SwapState.TERMINATED, ActionType.CORR));
        assertTrue(service.isActionPermitted(SwapState.TERMINATED, ActionType.VALU));
        assertTrue(service.isActionPermitted(SwapState.TERMINATED, ActionType.MARU));
        assertTrue(service.isActionPermitted(SwapState.TERMINATED, ActionType.EROR));
        assertFalse(service.isActionPermitted(SwapState.TERMINATED, ActionType.PRTO));
        assertFalse(service.isActionPermitted(SwapState.TERMINATED, ActionType.TERM));
    }

    @Test
    public void testErroredState() {
        assertFalse(service.isActionPermitted(SwapState.ERRORED, ActionType.MODI));
        assertFalse(service.isActionPermitted(SwapState.ERRORED, ActionType.CORR));
        assertFalse(service.isActionPermitted(SwapState.ERRORED, ActionType.VALU));
        assertFalse(service.isActionPermitted(SwapState.ERRORED, ActionType.MARU));
        assertFalse(service.isActionPermitted(SwapState.ERRORED, ActionType.PRTO));
        assertFalse(service.isActionPermitted(SwapState.ERRORED, ActionType.EROR));
        assertFalse(service.isActionPermitted(SwapState.ERRORED, ActionType.TERM));
    }

    @Test
    public void testExpiredOrMaturedState() {
        assertTrue(service.isActionPermitted(SwapState.EXPIRED, ActionType.MODI));
        assertTrue(service.isActionPermitted(SwapState.EXPIRED, ActionType.CORR));
        assertTrue(service.isActionPermitted(SwapState.EXPIRED, ActionType.EROR));
        assertTrue(service.isActionPermitted(SwapState.EXPIRED, ActionType.VALU));
        assertTrue(service.isActionPermitted(SwapState.EXPIRED, ActionType.MARU));
        assertFalse(service.isActionPermitted(SwapState.EXPIRED, ActionType.PRTO));
        assertFalse(service.isActionPermitted(SwapState.EXPIRED, ActionType.TERM));

        assertTrue(service.isActionPermitted(SwapState.MATURED, ActionType.MODI));
        assertTrue(service.isActionPermitted(SwapState.MATURED, ActionType.CORR));
        assertTrue(service.isActionPermitted(SwapState.MATURED, ActionType.EROR));
        assertTrue(service.isActionPermitted(SwapState.MATURED, ActionType.VALU));
        assertTrue(service.isActionPermitted(SwapState.MATURED, ActionType.MARU));
        assertFalse(service.isActionPermitted(SwapState.MATURED, ActionType.PRTO));
        assertFalse(service.isActionPermitted(SwapState.MATURED, ActionType.TERM));
    }
}