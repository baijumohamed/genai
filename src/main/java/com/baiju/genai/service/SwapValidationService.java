package com.baiju.genai.service;

import com.baiju.genai.domain.ActionType;
import com.baiju.genai.domain.SwapState;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Set;

public class SwapValidationService {

    private static final EnumMap<SwapState, Set<ActionType>> permittedActions = new EnumMap<>(SwapState.class);

    static {
        permittedActions.put(SwapState.OPEN, EnumSet.of(ActionType.MODI, ActionType.CORR, ActionType.VALU, ActionType.MARU, ActionType.PRTO, ActionType.EROR, ActionType.TERM));
        permittedActions.put(SwapState.TERMINATED, EnumSet.of(ActionType.MODI, ActionType.CORR, ActionType.VALU, ActionType.MARU, ActionType.EROR));
        permittedActions.put(SwapState.ERRORED, EnumSet.noneOf(ActionType.class));
        permittedActions.put(SwapState.EXPIRED, EnumSet.of(ActionType.MODI, ActionType.CORR, ActionType.EROR, ActionType.VALU, ActionType.MARU));
        permittedActions.put(SwapState.MATURED, EnumSet.of(ActionType.MODI, ActionType.CORR, ActionType.EROR, ActionType.VALU, ActionType.MARU));
    }

    public boolean isActionPermitted(SwapState state, ActionType action) {
        Set<ActionType> permitted = permittedActions.get(state);
        return permitted != null && permitted.contains(action);
    }
}